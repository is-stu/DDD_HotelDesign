package hotelddd.tewar.usecase.inventory;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.inventory.Inventory;
import hotelddd.tewar.domain.inventory.command.CreateInventory;

public class CreateInventoryUseCase extends UseCase<RequestCommand<CreateInventory>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateInventory> createInventoryRequestCommand) {
        var command = createInventoryRequestCommand.getCommand();
        var inventory = new Inventory(command.getInventoryId(), command.getFood(), command.getUtensil());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));
    }
}
