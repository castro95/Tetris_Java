package game.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.googlecode.lanterna.input.Key.Kind;

// arrowup = > rotate
// arrowleft => left
// arrowright => right
public class Input {
	private String key;
	private Kind kind;
	private Long time = System.currentTimeMillis();

	public Input(String key, Kind kind) {
		this.key = key;
		this.kind = kind;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
		Date d = new Date(this.getTime());
		return "Input [key=" + key + ", kind=" + kind + ", time=" + sdf.format(d) + "]";
	}
}
