import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public final class Bot extends TelegramLongPollingBot {

    private String BOT_USERNAME;
    private String BOT_TOKEN;

    public Bot(String botUsername, String botToken) {
        this.BOT_USERNAME = botUsername;
        this.BOT_TOKEN = botToken;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        System.out.println(message);
        SendMessage sendMessage;
        if (message.startsWith("/")) {

        }
        else {
            sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Sorry, I can't talk. I'm just a machine executing your commands.");
            this.execute(sendMessage);
        }
    }
}
