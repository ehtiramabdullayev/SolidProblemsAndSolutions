package solution.epam;

enum Animal {
    DOG {
        @Override
        void speak() {
            System.out.println("Woof!");

        }

    }, CAT {
        @Override
        void speak() {
            System.out.println("Meow!");

        }
    }, DUCK {
        @Override
        void speak() {
            System.out.println("Quack!");
        }
    };

    abstract void speak();

}
