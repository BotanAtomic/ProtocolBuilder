package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InviteInHavenBagMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6642;
    private boolean _isInitialized = false;
    private CharacterMinimalInformations guestInformations;
    private boolean accept = false;
    private FuncTree _guestInformationstree;


    public void serialize(ICustomDataOutput param1) {
         this.guestInformations.serializeAs_CharacterMinimalInformations(param1);
         param1.writeBoolean(this.accept);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guestInformations = new CharacterMinimalInformations();
         this.guestInformations.deserialize(param1);
         this.accept = param1.readBoolean();
    }

}