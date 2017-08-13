package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class DareSubscribedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6660;
    private boolean _isInitialized = false;
    private Number dareId = 0;
    private boolean success = false;
    private boolean subscribe = false;
    private DareVersatileInformations dareVersatilesInfos;
    private FuncTree _dareVersatilesInfostree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.subscribe);
         param1.writeByte(_loc2_);
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         this.dareVersatilesInfos.serializeAs_DareVersatileInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.subscribe = BooleanByteWrapper.getFlag(_loc2_,1);
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareSubscribedMessage.dareId.");
         }
         this.dareVersatilesInfos = new DareVersatileInformations();
         this.dareVersatilesInfos.deserialize(param1);
    }

}