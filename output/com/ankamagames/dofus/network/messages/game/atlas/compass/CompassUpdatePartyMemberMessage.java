package com.ankamagames.dofus.network.messages.game.atlas.compass;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinates;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CompassUpdatePartyMemberMessage extends CompassUpdateMessage implements INetworkMessage {

    private int protocolId = 5589;
    private boolean _isInitialized = false;
    private Number memberId = 0;
    private boolean active = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CompassUpdateMessage(param1);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         param1.writeBoolean(this.active);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CompassUpdateMessage.type.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.coords = ProtocolTypeManager.getInstance(MapCoordinates,_loc2_);
         this.coords.deserialize(param1);
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of CompassUpdatePartyMemberMessage.memberId.");
         }
         this.active = param1.readBoolean();
    }

}