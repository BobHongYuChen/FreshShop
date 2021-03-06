package app.freshec.bob.com.freshec;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import app.freshec.bob.com.latte_core.delegates.LatteDelegate;
import app.freshec.bob.com.latte_core.net.RestClient;
import app.freshec.bob.com.latte_core.net.callback.IError;
import app.freshec.bob.com.latte_core.net.callback.IFailure;
import app.freshec.bob.com.latte_core.net.callback.ISuccess;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    //测试
    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
