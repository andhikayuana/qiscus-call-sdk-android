package com.qiscus.rtc.engine.hub;

import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;

/**
 * Created by fitra on 2/10/17.
 */

public interface HubSignal {
    public static class SignalParameters {
        public final String clientId;
        public final String roomId;
        public final boolean videoEnabled;
        public final boolean initiator;
        public final String target;

        public SignalParameters(String clientId, String roomId, boolean initiator, boolean videoEnabled, String target) {
            this.clientId = clientId;
            this.roomId = roomId;
            this.initiator = initiator;
            this.videoEnabled = videoEnabled;
            this.target = target;
        }
    }

    static interface SignalEvents {
        public void onLoggedinToRoom();
        public void onPnReceived();
        public void onCallAccepted();
        public void onCallRejected();
        public void onCallCanceled();
        public void onRemoteSdp(final SessionDescription sdp);
        public void onRemoteCandidate(final IceCandidate candidate);
        public void onClose();
        public void onError(final String description);
    }

    public void connect();
    public void acceptCall();
    public void rejectCall();
    public void cancelCall();
    public void endCall();
    public void sendOffer(SessionDescription sdp);
    public void sendAnswer(SessionDescription sdp);
    public void sendCandidate(IceCandidate candidate);
    public void notifyConnect();
    public void notifyState(String state, String value);
    public void ping();
    public void disconnect();
}

