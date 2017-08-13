package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameRolePlayShowActorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5632;
    private boolean _isInitialized = false;
    private GameRolePlayActorInformations informations;
    private FuncTree _informationstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.informations.getTypeId());
         this.informations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         this.informations.deserialize(param1);
    }

}