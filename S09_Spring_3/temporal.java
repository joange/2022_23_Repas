

@Service
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	PeopleRepository peopleRepository;
	
	@Override
	public People savePeople(People people) {
		People savedPeople=peopleRepository.save(people);
		return savedPeople;
	}

	@Override
	public People updatePeople(People people) {
		Optional<People> oldPeople=peopleRepository.findById(people.getIdPeople());
		if (oldPeople.isPresent()) {
			People p=oldPeople.get();
			p.setAge(people.getAge());
			p.setName(people.getName());
			People newPeople=peopleRepository.save(p);
			return newPeople;
		}
		else {
			return people;
		}

	}

	@Override
	public People getPeopleById(Long id) {
		Optional<People> people=peopleRepository.findById(id);
		if (people.isPresent())
			return people.get();
		else
			return null;
	}

	@Override
	public List<People> listAllPeople() {
		return peopleRepository.findAll();
	}

	@Override
	public void deletePeople(Long id) {
		peopleRepository.deleteById(id);
		
	}

	
}

//--------------------------------------------

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Override
	public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart newShoppingCart=shoppingCartRepository.save(shoppingCart);
		return newShoppingCart;
	}

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getShoppingCartById(Long id) {
		Optional<ShoppingCart> shoppingCart=shoppingCartRepository.findById(id);
		if (shoppingCart.isPresent()) {
			return shoppingCart.get();
		}
		else
			return null;
	}

	@Override
	public List<ShoppingCart> listAllShoppingCarts() {
		return shoppingCartRepository.findAll();
	}

	@Override
	public void deleteShoppingCart(Long id) {
		// TODO Auto-generated method stub
		
	}

}
