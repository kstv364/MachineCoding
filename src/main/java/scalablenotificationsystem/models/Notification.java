package scalablenotificationsystem.models;

public class Notification {
    private String userId;
    private String channelType;
    private String content;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public String getChannelType() {
        return channelType;
    }

    public String getContent() {
        return content;
    }
}
