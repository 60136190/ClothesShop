package Thainam.clothesshop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailActivity extends YouTubeBaseActivity {

    private static final String TAG = "DetailActivity";
    Button btnPlay;
    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener monInitializedListener;
    int REQUEST_VIDEO =12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG,"onCreate: Starting.");
        btnPlay = findViewById(R.id.btnPlay);
        mYouTubePlayerView =(YouTubePlayerView) findViewById(R.id.youtubePlay);
        Bundle bundle =getIntent().getExtras();
        if(bundle == null){
            return;
        }
        ItemScfi itemScfi = (ItemScfi) bundle.get("object");

        TextView tvdetail = findViewById(R.id.tv_detail1);
        TextView tvNameUser = findViewById(R.id.tv_name_user);

        tvNameUser.setText(itemScfi.getName());
        tvdetail.setText(itemScfi.getDetail());







    }

}