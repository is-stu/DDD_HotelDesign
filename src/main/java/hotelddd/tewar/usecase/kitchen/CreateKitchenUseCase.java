package hotelddd.tewar.usecase.kitchen;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.kitchen.Kitchen;
import hotelddd.tewar.domain.kitchen.command.CreateKitchen;

public class CreateKitchenUseCase extends UseCase<RequestCommand<CreateKitchen>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateKitchen> createKitchenRequestCommand) {

        var command = createKitchenRequestCommand.getCommand();
        var kitchen = new Kitchen(command.getKitchenId(), command.getDimension(), command.getChef());

        emit().onResponse(new ResponseEvents(kitchen.getUncommittedChanges()));

    }
}
