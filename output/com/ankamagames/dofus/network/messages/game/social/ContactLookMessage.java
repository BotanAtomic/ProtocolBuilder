package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContactLookMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5934;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private String playerName = "";
    private Number playerId = 0;
    private EntityLook look;
    private FuncTree _looktree;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeVarInt(this.requestId);
         param1.writeUTF(this.playerName);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readVarUhInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of ContactLookMessage.requestId.");
         }
         this.playerName = param1.readUTF();
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of ContactLookMessage.playerId.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

}