package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListMessage extends Basic {

    private int protocolId = 151;
    private boolean _isInitialized = false;
    private boolean hasStartupActions = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_BasicCharactersListMessage(param1);
         param1.writeBoolean(this.hasStartupActions);
    }

    public void deserialize(ICustomDataInput param1) {
         this.quiet = param1.readBoolean();
         this.hasStartupActions = param1.readBoolean();
    }

}