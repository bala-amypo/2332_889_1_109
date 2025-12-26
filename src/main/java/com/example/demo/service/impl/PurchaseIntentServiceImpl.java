@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRepository repository;

    public PurchaseIntentServiceImpl(PurchaseIntentRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) {
        return repository.save(intent);
    }

    @Override
    public List<PurchaseIntentRecord> getAllIntents() {
        return repository.findAll();
    }
}
