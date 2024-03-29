package ra.business.design;

public interface IProduct extends CRUD{
    void sortByPrice();
    void findByName();
    void  findWithin();
}
