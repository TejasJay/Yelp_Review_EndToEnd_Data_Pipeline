// ORM class for table 'yelp_reviews_csv'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Fri Mar 14 00:57:35 UTC 2025
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class yelp_reviews_csv extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("review_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.review_id = (String)value;
      }
    });
    setters.put("user_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.user_id = (String)value;
      }
    });
    setters.put("business_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.business_id = (String)value;
      }
    });
    setters.put("stars", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.stars = (Float)value;
      }
    });
    setters.put("useful", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.useful = (Integer)value;
      }
    });
    setters.put("funny", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.funny = (Integer)value;
      }
    });
    setters.put("cool", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.cool = (Integer)value;
      }
    });
    setters.put("text", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.text = (String)value;
      }
    });
    setters.put("date_", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        yelp_reviews_csv.this.date_ = (String)value;
      }
    });
  }
  public yelp_reviews_csv() {
    init0();
  }
  private String review_id;
  public String get_review_id() {
    return review_id;
  }
  public void set_review_id(String review_id) {
    this.review_id = review_id;
  }
  public yelp_reviews_csv with_review_id(String review_id) {
    this.review_id = review_id;
    return this;
  }
  private String user_id;
  public String get_user_id() {
    return user_id;
  }
  public void set_user_id(String user_id) {
    this.user_id = user_id;
  }
  public yelp_reviews_csv with_user_id(String user_id) {
    this.user_id = user_id;
    return this;
  }
  private String business_id;
  public String get_business_id() {
    return business_id;
  }
  public void set_business_id(String business_id) {
    this.business_id = business_id;
  }
  public yelp_reviews_csv with_business_id(String business_id) {
    this.business_id = business_id;
    return this;
  }
  private Float stars;
  public Float get_stars() {
    return stars;
  }
  public void set_stars(Float stars) {
    this.stars = stars;
  }
  public yelp_reviews_csv with_stars(Float stars) {
    this.stars = stars;
    return this;
  }
  private Integer useful;
  public Integer get_useful() {
    return useful;
  }
  public void set_useful(Integer useful) {
    this.useful = useful;
  }
  public yelp_reviews_csv with_useful(Integer useful) {
    this.useful = useful;
    return this;
  }
  private Integer funny;
  public Integer get_funny() {
    return funny;
  }
  public void set_funny(Integer funny) {
    this.funny = funny;
  }
  public yelp_reviews_csv with_funny(Integer funny) {
    this.funny = funny;
    return this;
  }
  private Integer cool;
  public Integer get_cool() {
    return cool;
  }
  public void set_cool(Integer cool) {
    this.cool = cool;
  }
  public yelp_reviews_csv with_cool(Integer cool) {
    this.cool = cool;
    return this;
  }
  private String text;
  public String get_text() {
    return text;
  }
  public void set_text(String text) {
    this.text = text;
  }
  public yelp_reviews_csv with_text(String text) {
    this.text = text;
    return this;
  }
  private String date_;
  public String get_date_() {
    return date_;
  }
  public void set_date_(String date_) {
    this.date_ = date_;
  }
  public yelp_reviews_csv with_date_(String date_) {
    this.date_ = date_;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof yelp_reviews_csv)) {
      return false;
    }
    yelp_reviews_csv that = (yelp_reviews_csv) o;
    boolean equal = true;
    equal = equal && (this.review_id == null ? that.review_id == null : this.review_id.equals(that.review_id));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.business_id == null ? that.business_id == null : this.business_id.equals(that.business_id));
    equal = equal && (this.stars == null ? that.stars == null : this.stars.equals(that.stars));
    equal = equal && (this.useful == null ? that.useful == null : this.useful.equals(that.useful));
    equal = equal && (this.funny == null ? that.funny == null : this.funny.equals(that.funny));
    equal = equal && (this.cool == null ? that.cool == null : this.cool.equals(that.cool));
    equal = equal && (this.text == null ? that.text == null : this.text.equals(that.text));
    equal = equal && (this.date_ == null ? that.date_ == null : this.date_.equals(that.date_));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof yelp_reviews_csv)) {
      return false;
    }
    yelp_reviews_csv that = (yelp_reviews_csv) o;
    boolean equal = true;
    equal = equal && (this.review_id == null ? that.review_id == null : this.review_id.equals(that.review_id));
    equal = equal && (this.user_id == null ? that.user_id == null : this.user_id.equals(that.user_id));
    equal = equal && (this.business_id == null ? that.business_id == null : this.business_id.equals(that.business_id));
    equal = equal && (this.stars == null ? that.stars == null : this.stars.equals(that.stars));
    equal = equal && (this.useful == null ? that.useful == null : this.useful.equals(that.useful));
    equal = equal && (this.funny == null ? that.funny == null : this.funny.equals(that.funny));
    equal = equal && (this.cool == null ? that.cool == null : this.cool.equals(that.cool));
    equal = equal && (this.text == null ? that.text == null : this.text.equals(that.text));
    equal = equal && (this.date_ == null ? that.date_ == null : this.date_.equals(that.date_));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.review_id = JdbcWritableBridge.readString(1, __dbResults);
    this.user_id = JdbcWritableBridge.readString(2, __dbResults);
    this.business_id = JdbcWritableBridge.readString(3, __dbResults);
    this.stars = JdbcWritableBridge.readFloat(4, __dbResults);
    this.useful = JdbcWritableBridge.readInteger(5, __dbResults);
    this.funny = JdbcWritableBridge.readInteger(6, __dbResults);
    this.cool = JdbcWritableBridge.readInteger(7, __dbResults);
    this.text = JdbcWritableBridge.readString(8, __dbResults);
    this.date_ = JdbcWritableBridge.readString(9, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.review_id = JdbcWritableBridge.readString(1, __dbResults);
    this.user_id = JdbcWritableBridge.readString(2, __dbResults);
    this.business_id = JdbcWritableBridge.readString(3, __dbResults);
    this.stars = JdbcWritableBridge.readFloat(4, __dbResults);
    this.useful = JdbcWritableBridge.readInteger(5, __dbResults);
    this.funny = JdbcWritableBridge.readInteger(6, __dbResults);
    this.cool = JdbcWritableBridge.readInteger(7, __dbResults);
    this.text = JdbcWritableBridge.readString(8, __dbResults);
    this.date_ = JdbcWritableBridge.readString(9, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(review_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(user_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(business_id, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeFloat(stars, 4 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeInteger(useful, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(funny, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(cool, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(text, 8 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(date_, 9 + __off, 12, __dbStmt);
    return 9;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(review_id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(user_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(business_id, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeFloat(stars, 4 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeInteger(useful, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(funny, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(cool, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(text, 8 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(date_, 9 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.review_id = null;
    } else {
    this.review_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.user_id = null;
    } else {
    this.user_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.business_id = null;
    } else {
    this.business_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.stars = null;
    } else {
    this.stars = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.useful = null;
    } else {
    this.useful = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.funny = null;
    } else {
    this.funny = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.cool = null;
    } else {
    this.cool = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.text = null;
    } else {
    this.text = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.date_ = null;
    } else {
    this.date_ = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.review_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, review_id);
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, user_id);
    }
    if (null == this.business_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, business_id);
    }
    if (null == this.stars) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.stars);
    }
    if (null == this.useful) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.useful);
    }
    if (null == this.funny) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.funny);
    }
    if (null == this.cool) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.cool);
    }
    if (null == this.text) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, text);
    }
    if (null == this.date_) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, date_);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.review_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, review_id);
    }
    if (null == this.user_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, user_id);
    }
    if (null == this.business_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, business_id);
    }
    if (null == this.stars) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.stars);
    }
    if (null == this.useful) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.useful);
    }
    if (null == this.funny) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.funny);
    }
    if (null == this.cool) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.cool);
    }
    if (null == this.text) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, text);
    }
    if (null == this.date_) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, date_);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(review_id==null?"null":review_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(business_id==null?"null":business_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stars==null?"null":"" + stars, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(useful==null?"null":"" + useful, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(funny==null?"null":"" + funny, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cool==null?"null":"" + cool, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(text==null?"null":text, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(date_==null?"null":date_, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(review_id==null?"null":review_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(user_id==null?"null":user_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(business_id==null?"null":business_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(stars==null?"null":"" + stars, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(useful==null?"null":"" + useful, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(funny==null?"null":"" + funny, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(cool==null?"null":"" + cool, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(text==null?"null":text, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(date_==null?"null":date_, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.review_id = null; } else {
      this.review_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.user_id = null; } else {
      this.user_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.business_id = null; } else {
      this.business_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stars = null; } else {
      this.stars = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.useful = null; } else {
      this.useful = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.funny = null; } else {
      this.funny = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cool = null; } else {
      this.cool = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.text = null; } else {
      this.text = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.date_ = null; } else {
      this.date_ = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.review_id = null; } else {
      this.review_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.user_id = null; } else {
      this.user_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.business_id = null; } else {
      this.business_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.stars = null; } else {
      this.stars = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.useful = null; } else {
      this.useful = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.funny = null; } else {
      this.funny = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.cool = null; } else {
      this.cool = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.text = null; } else {
      this.text = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.date_ = null; } else {
      this.date_ = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    yelp_reviews_csv o = (yelp_reviews_csv) super.clone();
    return o;
  }

  public void clone0(yelp_reviews_csv o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("review_id", this.review_id);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("business_id", this.business_id);
    __sqoop$field_map.put("stars", this.stars);
    __sqoop$field_map.put("useful", this.useful);
    __sqoop$field_map.put("funny", this.funny);
    __sqoop$field_map.put("cool", this.cool);
    __sqoop$field_map.put("text", this.text);
    __sqoop$field_map.put("date_", this.date_);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("review_id", this.review_id);
    __sqoop$field_map.put("user_id", this.user_id);
    __sqoop$field_map.put("business_id", this.business_id);
    __sqoop$field_map.put("stars", this.stars);
    __sqoop$field_map.put("useful", this.useful);
    __sqoop$field_map.put("funny", this.funny);
    __sqoop$field_map.put("cool", this.cool);
    __sqoop$field_map.put("text", this.text);
    __sqoop$field_map.put("date_", this.date_);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
