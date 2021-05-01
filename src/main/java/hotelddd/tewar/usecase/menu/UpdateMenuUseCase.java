package hotelddd.tewar.usecase.menu;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import hotelddd.tewar.domain.menu.Menu;
import hotelddd.tewar.domain.menu.command.UpdateMenu;

public class UpdateMenuUseCase extends UseCase<RequestCommand<UpdateMenu>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateMenu> updateMenuRequestCommand) {

        var command = updateMenuRequestCommand.getCommand();
        var menu = Menu.from(command.getMenuId(),retrieveEvents());
        menu.updateMenu(command.getMenuId(), command.getPlate(), command.getName());

        emit().onResponse(new ResponseEvents(menu.getUncommittedChanges()));
    }
}
