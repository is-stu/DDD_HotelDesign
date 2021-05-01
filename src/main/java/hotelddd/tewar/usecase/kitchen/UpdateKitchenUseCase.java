package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.kitchen.Kitchen;
import hotelddd.tewar.domain.kitchen.command.UpdateKitchen;

public class UpdateKitchenUseCase extends UseCase<RequestCommand<UpdateKitchen>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateKitchen> updateKitchenRequestCommand) {

        var command = updateKitchenRequestCommand.getCommand();
        var kitchen = Kitchen.from(command.getKitchenId(),retrieveEvents());
        kitchen.UpdateKitchen(command.getKitchenId(),command.getDimension());

        emit().onResponse(new ResponseEvents(kitchen.getUncommittedChanges()));

    }
}
