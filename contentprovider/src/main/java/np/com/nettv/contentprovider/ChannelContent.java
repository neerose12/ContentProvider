package np.com.nettv.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public final class ChannelContent implements Parcelable {

  public static final String TABLE = "livetv_channels";

  public static final class Columns implements BaseColumns {
    public static final String CHANNELID = "id";
    public static final String CHANNELNAME = "name";
    public static final String CHANNELLOGO = "logo";
    public static final String CHANNELTYPE = "type";

      public static final String[] ALL = {
              _ID, CHANNELID, CHANNELNAME,CHANNELLOGO,CHANNELTYPE
      };
  }



  public long id;
  public int channelId;
  public String channelName;
  public String channelLogo;
  public String channelType;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelLogo() {
        return channelLogo;
    }

    public void setChannelLogo(String channelLogo) {
        this.channelLogo = channelLogo;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public ChannelContent() {
    id = -1;
  }

  public ChannelContent(Cursor c) {
    id = c.getLong(c.getColumnIndexOrThrow(Columns._ID));
    channelId = c.getInt(c.getColumnIndexOrThrow(Columns.CHANNELID));
    channelName = c.getString(c.getColumnIndexOrThrow(Columns.CHANNELNAME));
    channelLogo = c.getString(c.getColumnIndexOrThrow(Columns.CHANNELLOGO));
    channelType = c.getString(c.getColumnIndexOrThrow(Columns.CHANNELTYPE));
  }

  public void populateValues(ContentValues values) {
    values.put(Columns.CHANNELID, channelId);
    values.put(Columns.CHANNELNAME, channelName);
    values.put(Columns.CHANNELLOGO, channelLogo);
    values.put(Columns.CHANNELTYPE, channelType);
  }

  private ChannelContent(Parcel in) {
    id = in.readLong();
    channelId = in.readInt();
    channelName = in.readString();
    channelLogo = in.readString();
    channelType = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(id);
    dest.writeInt(channelId);
    dest.writeString(channelName);
    dest.writeString(channelLogo);
    dest.writeString(channelType);
  }

  public static final Parcelable.Creator<ChannelContent> CREATOR = new Parcelable.Creator<ChannelContent>() {
    public ChannelContent createFromParcel(Parcel in) {
      return new ChannelContent(in);
    }

    public ChannelContent[] newArray(int size) {
      return new ChannelContent[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }
}
