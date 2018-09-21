package c_IteratorsAndComparators.Exercises.p08_PetClinics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Room> {
    private String name;
    private Room[] rooms;
    private List<Integer> accommodationIndexes;

    public Clinic(String name, int roomsCount) {
        this.name = name;
        this.setRooms(roomsCount);
        this.setAccommodationIndexes();
    }

    public boolean addPet(Pet pet) {
        Iterable<Integer> indexes = this.accommodationIndexes;

        for (Integer index : indexes) {
            if (this.rooms[index] == null) {
                this.rooms[index] = new Room(pet);
                return true;
            }
        }

        return false;
    }

    public boolean release() {
        Iterator<Room> releaseIterator = new ReleaseIterator();

        while (releaseIterator.hasNext()) {
            if (releaseIterator.next() != null) {
                releaseIterator.remove();
                return true;
            }
        }

        return false;
    }


    public Room getRoomByIndex(int index) {
        return this.rooms[index - 1];
    }

    public boolean hasEmptyRooms() {
        return Arrays.asList(this.rooms).contains(null);
    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms = new Room[roomsCount];
    }

    private void setAccommodationIndexes() {
        this.accommodationIndexes = new ArrayList<>();
        int middleIndex = this.rooms.length / 2;

        this.accommodationIndexes.add(middleIndex);

        if (middleIndex == 0) {
            return;
        }

        int leftIndex = middleIndex - 1;
        int rightIndex = middleIndex + 1;

        for (int i = 0; i < middleIndex; i++) {
            if (leftIndex >= 0) {
                this.accommodationIndexes.add(leftIndex--);
            }

            if (rightIndex < this.rooms.length) {
                this.accommodationIndexes.add(rightIndex++);
            }
        }
    }

    @Override
    public Iterator<Room> iterator() {
        return new ClinicIterator();
    }

    private final class ClinicIterator implements Iterator<Room> {
        private int index;

        public ClinicIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            return rooms[this.index++];
        }
    }

    private final class ReleaseIterator implements Iterator<Room> {
        private int index;
        private List<Integer> releaseIndexes;

        public ReleaseIterator() {
            this.index = 0;
            this.setReleaseIndexes();
        }

        private void setReleaseIndexes() {
            this.releaseIndexes = new ArrayList<>();
            int middleIndex = rooms.length / 2;
            this.releaseIndexes.add(middleIndex);

            if (middleIndex == 0) {
                return;
            }

            for (int i = middleIndex + 1; i < rooms.length; i++) {
                this.releaseIndexes.add(i);
            }

            for (int i = middleIndex - 1; i >= 0; i--) {
                this.releaseIndexes.add(i);
            }
        }

        @Override
        public boolean hasNext() {
            return this.index < this.releaseIndexes.size();
        }

        @Override
        public Room next() {
            return rooms[this.releaseIndexes.get(this.index++)];
        }

        @Override
        public void remove() {
            rooms[this.releaseIndexes.get(this.index - 1)] = null;
        }
    }
}
