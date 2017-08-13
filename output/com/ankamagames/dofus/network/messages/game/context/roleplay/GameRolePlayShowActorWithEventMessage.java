package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayShowActorWithEventMessage extends GameRolePlayShowActorMessage implements INetworkMessage {

    private int protocolId = 6407;
    private boolean _isInitialized = false;
    private int actorEventId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayShowActorMessage(param1);
         if(this.actorEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.actorEventId + ") on element actorEventId.");
         }
         param1.writeByte(this.actorEventId);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.informations = ProtocolTypeManager.getInstance(GameRolePlayActorInformations,_loc2_);
         this.informations.deserialize(param1);
         this.actorEventId = param1.readByte();
         if(this.actorEventId < 0)
         {
            throw new Exception("Forbidden value (" + this.actorEventId + ") on element of GameRolePlayShowActorWithEventMessage.actorEventId.");
         }
    }

}