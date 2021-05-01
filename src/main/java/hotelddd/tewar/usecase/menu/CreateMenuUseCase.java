package hotelddd.tewar.usecase.menu;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.menu.Menu;
import hotelddd.tewar.domain.menu.command.CreateMenu;

public class CreateMenuUseCase extends UseCase<RequestCommand<CreateMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMenu> createMenuRequestCommand) {
        var command = createMenuRequestCommand.getCommand();
        var menu = new Menu(command.getMenuId(), command.getPlate(), command.getName());

        emit().onResponse(new ResponseEvents(menu.getUncommittedChanges()));
    }
}
