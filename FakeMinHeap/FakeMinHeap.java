import java.util.*;

public class FakeMinHeap {
    private List<Integer> heap;
    
    public FakeMinHeap() {
        clear();
    }
    
    public int size() {
        return heap.size() - 1;
    }
    
    public Integer peek() {
        emptyExceptionCheck();
        
        return heap.get( 1 );
    }
    
    public boolean isEmpty() {
        return heap.size() <= 1;
    }
    
    public void add( Integer val ) {
        heap.add( val );
        reheapUp();
    }
    
    public Integer remove() {
        emptyExceptionCheck();
        
        Integer old = peek();
        
        
        if ( heap.size() > 2 ) {
            heap.set(1, heap.remove(heap.size() - 1) );
            reheapDown();
        }
        else {
            heap.remove( 1 );
        }
        
        return old;
    }
    
    
    //Min heap
    //Field: private List<Integer> heap
    private void reheapUp() {
        int slot = heap.size() - 1;
        heap.set( 0, heap.get( slot ) );
        int check = heap.get( 0 );
        while ( slot > 1 && heap.get( slot / 2 ) > check ) {
            heap.set( slot, heap.get( slot / 2 ) );
            slot = slot / 2;
        }
        heap.set( slot, check );
    }
    
    private void reheapDown() {
        int slot = 1;
        while ( slot * 2 < heap.size() && slot * 2 + 1 < heap.size() ) {
            if ( heap.get( slot * 2 ) < heap.get( slot * 2 + 1 ) ) {
                if ( heap.get( slot ) > heap.get( slot * 2 ) ) {
                    heap.set( 0, heap.get( slot ) );
                    heap.set( slot, heap.get( slot * 2 ) );
                    heap.set( slot * 2, heap.get( 0 ) );
                    slot *= 2;
                }
            }
            else {
                if ( heap.get( slot ) > heap.get( slot * 2 + 1 ) ) {
                    heap.set( 0, heap.get( slot ) );
                    heap.set( slot, heap.get( slot * 2 + 1 ) );
                    heap.set( slot * 2 + 1, heap.get( 0 ) );
                    slot *= 2 + 1;
                }
            }
        }
        if ( size() == 2 && heap.get( slot ) >= heap.get( slot * 2 ) ) {
            heap.set( 0, heap.get( slot ) );
            heap.set( slot, heap.get( slot * 2 ) );
            heap.set( slot * 2, heap.get( 0 ) );
        }
    }
    
    
    public String toString() {
        return heap.subList( 1, heap.size() ).toString();
    }
    
    public int hashCode() {
        return heap.subList( 1, heap.size() ).hashCode();
    }
    
    private void emptyExceptionCheck() {
        if ( isEmpty() ) {
            throw new NoSuchElementException();
        }
    }
    
    public void clear() {
        heap = new ArrayList<>();
        heap.add( null );
    }
}