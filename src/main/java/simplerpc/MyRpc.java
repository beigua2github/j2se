package simplerpc;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class MyRpc {
    public static void publishService(final Object service, int port) throws Exception {
        assert service != null;
        assert port > 0 && port < 65535;

        ServerSocket server = new ServerSocket(port);

        for (; ; ) {
            Socket socket = server.accept();
            new Thread(() -> {
                try {

                    //get methodName parameterTypes arguments
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                    String methodName = input.readUTF();
                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                    Object[] arguments = (Object[]) input.readObject();

                    //reflect to invoke method
                    Method method = service.getClass().getMethod(methodName, parameterTypes);
                    Object result = method.invoke(service, arguments);

                    //write output
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(result);
                    input.close();
                    output.close();
                    socket.close();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static <T> T referService(final Class<T> interfaceClass, final String host, final int port) {
        assert interfaceClass != null;
        assert host != null;
        assert port > 0 && port < 65535;

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, args) -> {
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
            Socket socket = null;
            try {
                //connection
                socket = new Socket(host, port);


                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);

                input = new ObjectInputStream(socket.getInputStream());
                Object result = input.readObject();

                if (result instanceof Throwable) {
                    throw (Throwable) result;
                }

                return result;
            } finally {
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        EchoService echoService = new EchoServiceImpl();
        MyRpc.publishService(echoService, 5535);

    }
}
