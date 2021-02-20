package videochatroom;


import java.util.Vector;
import javax.media.*;
import javax.media.format.*;

public class ChatCapture {

    MediaLocator audioCapDevLoc = null;
    MediaLocator videoCapDevLoc = null;
    CaptureDeviceInfo audioCapDevInfo = null;
    CaptureDeviceInfo videoCapDevInfo = null;
    Vector audioCapDevList = null;
    Vector videoCapDevList = null;

    public ChatCapture() {
        audioCapDevList = CaptureDeviceManager.getDeviceList(new AudioFormat(
                AudioFormat.LINEAR));
        videoCapDevList = CaptureDeviceManager.getDeviceList(new VideoFormat(
                VideoFormat.YUV));
        if ((audioCapDevList.size() > 0)) {
            audioCapDevInfo = (CaptureDeviceInfo) audioCapDevList.elementAt(0);
            audioCapDevLoc = audioCapDevInfo.getLocator();
        }
        if ((videoCapDevList.size() > 0)) {
            videoCapDevInfo = (CaptureDeviceInfo) videoCapDevList.elementAt(0);
            videoCapDevLoc = videoCapDevInfo.getLocator();
        }
    }

    public String[] getAudioCapDevName() {
        CaptureDeviceInfo cdi = null;
        String capDevName[] = new String[audioCapDevList.size()];
        if (audioCapDevList.size() > 0) {
            for (int i = 0; i < audioCapDevList.size(); i++) {
                cdi = (CaptureDeviceInfo) audioCapDevList.elementAt(i);
                capDevName[i] = cdi.getName();
            }
        } else {
            return null;
        }
        return capDevName;
    }

    public String[] getVideoCapDevName() {
        CaptureDeviceInfo cdi = null;
        String capDevName[] = new String[videoCapDevList.size()];
        if (videoCapDevList.size() > 0) {
            for (int i = 0; i < videoCapDevList.size(); i++) {
                cdi = (CaptureDeviceInfo) videoCapDevList.elementAt(i);
                capDevName[i] = cdi.getName();
            }
        } else {
            return null;
        }
        return capDevName;
    }

}
