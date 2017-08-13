package com.ankamagames.dofus.network.messages.game.context.roleplay.party.companion;

import com.ankamagames.dofus.network.messages.game.context.roleplay.party.PartyUpdateLightMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyCompanionUpdateLightMessage extends PartyUpdateLightMessage implements INetworkMessage {

    private int protocolId = 6472;
    private boolean _isInitialized = false;
    private int indexId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
         }
         param1.writeVarShort(this.prospecting);
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
         if(this.indexId < 0)
         {
            throw new Exception("Forbidden value (" + this.indexId + ") on element indexId.");
         }
         param1.writeByte(this.indexId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyUpdateLightMessage(param1);
         this.indexId = param1.readByte();
         if(this.indexId < 0)
         {
            throw new Exception("Forbidden value (" + this.indexId + ") on element of PartyCompanionUpdateLightMessage.indexId.");
         }
    }

}