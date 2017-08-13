package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InviteInHavenBagOfferMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6643;
    private boolean _isInitialized = false;
    private CharacterMinimalInformations hostInformations;
    private int timeLeftBeforeCancel = 0;
    private FuncTree _hostInformationstree;


    public void serialize(ICustomDataOutput param1) {
         this.hostInformations.serializeAs_CharacterMinimalInformations(param1);
         param1.writeVarInt(this.timeLeftBeforeCancel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.hostInformations = new CharacterMinimalInformations();
         this.hostInformations.deserialize(param1);
         this.timeLeftBeforeCancel = param1.readVarInt();
    }

}