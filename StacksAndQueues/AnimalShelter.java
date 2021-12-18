package StacksAndQueues;

import java.util.LinkedList;

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name){
        this.name = name;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal animal){
        return this.order < animal.order;
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}

class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;
        if(animal instanceof Dog){
            dogs.addLast((Dog) animal);
        }else{
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0){
            return dequeueCat();
        }else if(cats.size() == 0){
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDog();
        }else{
            return dequeueCat();
        }
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    public Cat dequeueCat(){
        return cats.poll();
    }
}

public class AnimalShelter {
    public static void main(String[] args) {
        AnimalQueue animalQueue = new AnimalQueue();
        Dog dog = new Dog("Golden");
        Cat cat = new Cat("Tom");

        animalQueue.enqueue(dog);
        animalQueue.enqueue(cat);
        System.out.println(animalQueue.dequeueAny().name);
    }
}
