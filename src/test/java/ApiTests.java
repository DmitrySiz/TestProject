import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ApiTests {
    private String username = "qwerty";
    private String password = "qwerty1234";
    private String errorMsgIbExpected = "Превышено максимальное количество попыток неудачного ввода логина и пароля, пользователь был заблокирован. Для разблокировки пользователя обратитесь, пожалуйста, в контактный центр Банка по телефону 8 (800)200-0-981";

    @Test
    public void internetBankLoginFail() throws IOException {
        Api api = new Api();
        String errorMsgIbActual = api.getErrorMessage(username,password);
        Assert.assertEquals("errorMsgIb",errorMsgIbExpected,errorMsgIbActual);
    }
}
