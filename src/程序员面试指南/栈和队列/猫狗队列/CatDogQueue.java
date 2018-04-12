package 程序员面试指南.栈和队列.猫狗队列;

import java.util.ArrayDeque;

public class CatDogQueue {
    ArrayDeque<PetEntry> dogQueue = new ArrayDeque<>();
    ArrayDeque<PetEntry> catQueue = new ArrayDeque<>();
    private int count;

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQueue.add(new PetEntry(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            catQueue.add(new PetEntry(pet, count++));
        } else {
            throw new RuntimeException("类型不对");
        }
    }

    public Pet pollAll() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new RuntimeException("队列为空");
        } else if (dogQueue.isEmpty()) {
            return catQueue.pop().getPet();
        } else if (catQueue.isEmpty()) {
            return dogQueue.pop().getPet();
        } else {
            if (dogQueue.peekFirst().getTime() < catQueue.peekFirst().getTime()) {
                return dogQueue.pop().getPet();
            } else {
                return catQueue.pop().getPet();
            }
        }
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("dog队列为空");
        } else {
            return (Dog) dogQueue.pop().getPet();
        }
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("cat队列为空");
        } else {
            return (Cat) catQueue.pop().getPet();
        }
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
class PetEntry{
    private Pet pet;
    private int time;

    public PetEntry(Pet pet, int time) {
        this.pet = pet;
        this.time = time;
    }

    public Pet getPet() {
        return pet;
    }

    public int getTime() {
        return time;
    }
}
    class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }
    public String getPetType(){
        return this.type;
    }
}

    class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}
    class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}
