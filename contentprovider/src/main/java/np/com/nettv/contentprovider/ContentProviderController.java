package np.com.nettv.contentprovider;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderController {

    ChannelContent channelContent;
    Context context;

    public ContentProviderController(Context context) {
        this.context = context;
    }

    public void save(ContentValues values) {
        context.getContentResolver().insert(ChannelProvider.CHANNEL_URI, values);
    }


    public List<ChannelContent> getChannels() {
        List<ChannelContent> channelContents = new ArrayList<>();
        ContentProviderClient content = context.getContentResolver().acquireContentProviderClient(ChannelProvider.CHANNEL_URI);
        Cursor c = null;
        try {
            c = content.query(ChannelProvider.CHANNEL_URI,
                    null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            channelContents = new ArrayList<>();
        }
        int numColumns = c.getCount();
        Log.d("checkingContent", "columv   " + numColumns);
        if (c != null) {
            while (c.moveToNext()) {
                channelContents.add(new ChannelContent(c));
            }
            c.close();
        }
        return channelContents;
    }


    public void deleteChannelAll(){
        context.getContentResolver().delete(ChannelProvider.CHANNEL_URI, null,null);
    }
    public void deleteChannel(int channelId,String type){
        String[] selctionArg = {String.valueOf(channelId),type};

        context.getContentResolver().delete(ChannelProvider.CHANNEL_URI,
                ChannelContent.Columns.CHANNELID+"=?"
                        +ChannelContent.Columns.CHANNELTYPE+"=?",selctionArg);
    }
}
