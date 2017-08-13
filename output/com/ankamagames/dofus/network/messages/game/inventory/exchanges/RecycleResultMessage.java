package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class RecycleResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6601;
    private boolean _isInitialized = false;
    private int nuggetsForPrism = 0;
    private int nuggetsForPlayer = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6601;
    }

    public RecycleResultMessage initRecycleResultMessage(int param1,int  param2) {
         this.nuggetsForPrism = param1;
         this.nuggetsForPlayer = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.nuggetsForPrism = 0;
         this.nuggetsForPlayer = 0;
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
         this.serializeAs_RecycleResultMessage(param1);
    }

    public void serializeAs_RecycleResultMessage(ICustomDataOutput param1) {
         if(this.nuggetsForPrism < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPrism + ") on element nuggetsForPrism.");
         }
         param1.writeVarInt(this.nuggetsForPrism);
         if(this.nuggetsForPlayer < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPlayer + ") on element nuggetsForPlayer.");
         }
         param1.writeVarInt(this.nuggetsForPlayer);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_RecycleResultMessage(param1);
    }

    public void deserializeAs_RecycleResultMessage(ICustomDataInput param1) {
         this._nuggetsForPrismFunc(param1);
         this._nuggetsForPlayerFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_RecycleResultMessage(param1);
    }

    public void deserializeAsyncAs_RecycleResultMessage(FuncTree param1) {
         param1.addChild(this._nuggetsForPrismFunc);
         param1.addChild(this._nuggetsForPlayerFunc);
    }

    private void _nuggetsForPrismFunc(ICustomDataInput param1) {
         this.nuggetsForPrism = param1.readVarUhInt();
         if(this.nuggetsForPrism < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPrism + ") on element of RecycleResultMessage.nuggetsForPrism.");
         }
    }

    private void _nuggetsForPlayerFunc(ICustomDataInput param1) {
         this.nuggetsForPlayer = param1.readVarUhInt();
         if(this.nuggetsForPlayer < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPlayer + ") on element of RecycleResultMessage.nuggetsForPlayer.");
         }
    }

}