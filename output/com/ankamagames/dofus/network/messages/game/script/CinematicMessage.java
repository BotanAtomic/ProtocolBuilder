package com.ankamagames.dofus.network.messages.game.script;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CinematicMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6053;
    private boolean _isInitialized = false;
    private int cinematicId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6053;
    }

    public CinematicMessage initCinematicMessage(int param1) {
         this.cinematicId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cinematicId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CinematicMessage(param1);
    }

    public void serializeAs_CinematicMessage(ICustomDataOutput param1) {
         if(this.cinematicId < 0)
         {
            throw new Exception("Forbidden value (" + this.cinematicId + ") on element cinematicId.");
         }
         param1.writeVarShort(this.cinematicId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CinematicMessage(param1);
    }

    public void deserializeAs_CinematicMessage(ICustomDataInput param1) {
         this._cinematicIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CinematicMessage(param1);
    }

    public void deserializeAsyncAs_CinematicMessage(FuncTree param1) {
         param1.addChild(this._cinematicIdFunc);
    }

    private void _cinematicIdFunc(ICustomDataInput param1) {
         this.cinematicId = param1.readVarUhShort();
         if(this.cinematicId < 0)
         {
            throw new Exception("Forbidden value (" + this.cinematicId + ") on element of CinematicMessage.cinematicId.");
         }
    }

}