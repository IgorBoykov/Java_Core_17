package Task;

import Task.Iterator.Collection;

public class Application {

	public static void main(String[] args) {

		Number[] array = { 23, 12, 1, 45, 65, 8, 11, 0, 99, 77 };

		Collection coll = new Collection(array);

		Iterator iteratorForward = coll.createForward();

		while (iteratorForward.hasNext()) {
			Number iteratorForwardNew = iteratorForward.next();
			if (iteratorForwardNew.intValue() % 2 != 0) {
				iteratorForwardNew = 0;
			}
			System.out.println(iteratorForwardNew);
		}
		System.out.println("--------------");

		Iterator iteratorBackward = coll.createBackward();

		while (iteratorBackward.hasNext()) {
			System.out.println(iteratorBackward.next());
		}

		System.out.println("--------------");

		Iterator iteratorAnonymous = coll.createAnonymous();

		int n = 0;
		while (iteratorAnonymous.hasNext()) {
			Number itaratorAnonymousNew = iteratorAnonymous.next();
			if (n % 3 == 0) {
				if (itaratorAnonymousNew.intValue() % 2 != 0) {
					System.out.println(itaratorAnonymousNew);
				}
			}
			n++;
		}

		System.out.println("--------------");

		Iterator iteratorLocal = coll.createLocal();

		int m = 0;
		while (iteratorLocal.hasNext()) {
			Number iteratorLocalNew = iteratorLocal.next();
			if (m % 5 == 0) {
				if (iteratorLocalNew.intValue() % 2 == 0) {
					iteratorLocalNew = iteratorLocalNew.intValue() - 100;
					System.out.println(iteratorLocalNew);
				}
			}
			m++;
		}

		System.out.println("--------------");

		Iterator iteratorStatic = Collection.createStaticIterator();

		while (iteratorStatic.hasNext()) {
			Number iteratorStaticNew = iteratorStatic.next();
			if (iteratorStaticNew.intValue() % 2 == 0) {
				iteratorStaticNew = iteratorStaticNew.intValue() + 1;
				System.out.println(iteratorStaticNew);
			}

		}
	}

}
