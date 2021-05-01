package hotelddd.tewar.usecase.inventory;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.inventory.Inventory;
import hotelddd.tewar.domain.inventory.command.UpdateInventory;

public class UpdateInventoryUseCase extends UseCase<RequestCommand<UpdateInventory>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateInventory> updateInventoryRequestCommand) {

        var command = updateInventoryRequestCommand.getCommand();
        var inventory = Inventory.from(command.getInventoryId(), retrieveEvents());
        inventory.UpdateInventory(command.getInventoryId(), command.getFood(), command.getUtensil());

        emit().onResponse(new ResponseEvents(inventory.getUncommittedChanges()));

    }
}
