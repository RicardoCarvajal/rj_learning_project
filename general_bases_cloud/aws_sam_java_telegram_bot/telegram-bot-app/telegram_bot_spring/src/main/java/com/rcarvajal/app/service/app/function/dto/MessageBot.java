package com.rcarvajal.app.service.app.function.dto;

public class MessageBot {
    private String id;

    private String text;

    public MessageBot() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //Builder
    public static MessageTelegramBuilder builder() {
        return new MessageTelegramBuilder();
    }
    public static class MessageTelegramBuilder {
        private String id;
        private String text;
        public MessageTelegramBuilder withId(String id) {
            this.id = id;
            return this;
        }
        public MessageTelegramBuilder withText(String text) {
            this.text = text;
            return this;
        }
        public MessageBot build() {
            MessageBot messageTelegram = new MessageBot();
            messageTelegram.setId(id);
            messageTelegram.setText(text);
            return messageTelegram;
        }
    }

}
