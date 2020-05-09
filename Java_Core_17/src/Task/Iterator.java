package Task;

public interface Iterator {

	public boolean hasNext();

	public Number next();

	class Collection {

		private static Number[] array;

		Collection(Number[] array) {
			Collection.array = array;
		}

		public class Forward implements Iterator {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < array.length;
			}

			@Override
			public Number next() {
				return array[count++];
			}
		}

		public Forward createForward() {
			return new Forward();
		}

		public class Backward implements Iterator {

			int count = array.length - 1;

			@Override
			public boolean hasNext() {
				return count >= 0;
			}

			@Override
			public Number next() {
				return array[count--];
			}

		}

		public Backward createBackward() {
			return new Backward();
		}

		public Iterator createAnonymous() {
			return new Iterator() {

				public int count = array.length - 1;

				@Override
				public Number next() {
					return array[count--];
				}

				@Override
				public boolean hasNext() {
					return count >= 0;
				}
			};
		}

		public Iterator createLocal() {
			class localIterator implements Iterator {

				private int count = 0;

				@Override
				public boolean hasNext() {
					return count < array.length;
				}

				@Override
				public Number next() {
					return array[count++];
				}
			}
			return new localIterator();
		}

		private static class staticIterator implements Iterator {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < array.length;
			}

			@Override
			public Number next() {
				return array[count++];
			}
		}

		public static staticIterator createStaticIterator() {
			return new staticIterator();
		}
	}
}
