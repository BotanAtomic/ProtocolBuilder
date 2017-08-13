package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyUpdateLightMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6054;
    private boolean _isInitialized = false;
    private Number id = 0;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
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
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of PartyUpdateLightMessage.id.");
         }
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyUpdateLightMessage.lifePoints.");
         }
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyUpdateLightMessage.maxLifePoints.");
         }
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyUpdateLightMessage.prospecting.");
         }
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyUpdateLightMessage.regenRate.");
         }
    }

}