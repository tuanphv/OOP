package Interface;
public interface IList<T> {
    public void docFile();
    public void ghiFile();
    // them 1 doi tuong vao cuoi danh sach
    public void add(T obj);
    // xoa doi tuong obj
    public void remove(T obj);
    // lay vi tri cua doi tuong trong danh sach
    public int indexOf(String ma);
    // lay doi tuong theo id
    public T get(String ma);
    // kiem tra danh sach rong
    public boolean isEmpty();
    // lay do dai danh sach
    public int size();
}
