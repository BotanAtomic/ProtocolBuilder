package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class IdolSelectErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6584;
    private boolean _isInitialized = false;
    private int reason = 0;
    private int idolId = 0;
    private boolean activate = false;
    private boolean party = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.activate);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.party);
         param1.writeByte(_loc2_);
         param1.writeByte(this.reason);
         if(this.idolId < 0)
         {
            throw new Exception("Forbidden value (" + this.idolId + ") on element idolId.");
         }
         param1.writeVarShort(this.idolId);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.activate = BooleanByteWrapper.getFlag(_loc2_,0);
         this.party = BooleanByteWrapper.getFlag(_loc2_,1);
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of IdolSelectErrorMessage.reason.");
         }
         this.idolId = param1.readVarUhShort();
         if(this.idolId < 0)
         {
            throw new Exception("Forbidden value (" + this.idolId + ") on element of IdolSelectErrorMessage.idolId.");
         }
    }

}