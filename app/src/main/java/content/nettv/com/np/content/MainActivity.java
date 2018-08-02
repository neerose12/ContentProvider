package content.nettv.com.np.content;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import np.com.nettv.contentprovider.ChannelContent;
import np.com.nettv.contentprovider.ContentProviderController;

public class MainActivity extends AppCompatActivity {

    ContentProviderController contentProviderController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentProviderController = new ContentProviderController(this);
        saveChannels();
    }


    public void saveChannels(){
        ContentValues contentValues  = new ContentValues();
        contentValues.put(ChannelContent.Columns.CHANNELID,1);
        contentValues.put(ChannelContent.Columns.CHANNELNAME,"Niroj");
        contentValues.put(ChannelContent.Columns.CHANNELLOGO,"Logo");
        contentValues.put(ChannelContent.Columns.CHANNELTYPE,"fav");
        contentProviderController.save(contentValues);
    }
}
