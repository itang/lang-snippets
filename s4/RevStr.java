import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RevStr {

	public String rev(/* @Nullable */final String s) {
		if (s == null) {
			return null;
		}
		if (s.length() == 0) {
			return "";
		}

		final StringWrapper chars = new StringWrapper(s);
		final List<String> ws = new ArrayList<>();
		StringBuilder word = null;
		StringBuilder space = null;
		for (char c : chars) {
			if (isLetter(c)) {
				if (word == null) {
					word = new StringBuilder();
				}
				word.append(c);
			} else {
				if (space == null) {
					space = new StringBuilder();
				}
				space.append(c);
			}

			if (chars.hasNext()) {
				char n = chars.getNext();
				if (isLetter(n)) {
					addIfNoEmpty(ws, space);
					space = null;
				} else {
					addIfNoEmpty(ws, word);
					word = null;
				}
			} else {
				addIfNoEmpty(ws, word);
				addIfNoEmpty(ws, space);
			}
		}

		final StringBuilder sb = new StringBuilder();
		for (int i = ws.size() - 1; i >= 0; i--) {
			sb.append(ws.get(i));
		}
		return sb.toString();
	}

	private boolean isEmpty(/* @Nullable */final StringBuilder sb) {
		return sb == null || sb.length() == 0;
	}

	private boolean isLetter(final char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	@SuppressWarnings("unused")
	private boolean isSpace(final char c) {
		return c == ' ';
	}

	private void addIfNoEmpty(final List<String> ws, final StringBuilder s) {
		if (!isEmpty(s)) {
			ws.add(s.toString());
		}
	}

	interface NextGetter<T> {
		T getNext();

		boolean isLast();
	}

	static class StringWrapper implements Iterable<Character>,
			Iterator<Character>, NextGetter<Character> {
		private final String str;
		private final int charsLen;

		private int index;

		public StringWrapper(String s) {
			this.str = s;
			this.charsLen = s.length();
			this.index = 0;
		}

		@Override
		public Iterator<Character> iterator() {
			return this;
		}

		@Override
		public boolean hasNext() {
			return index <= charsLen - 1;
		}

		@Override
		public Character next() {
			return str.charAt(index++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Character getNext() {
			return str.charAt(index);
		}

		public boolean isLast() {
			return index == charsLen;
		}
	}
}
