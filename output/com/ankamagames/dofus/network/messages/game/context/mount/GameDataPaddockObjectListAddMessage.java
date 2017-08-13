package package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameDataPaddockObjectListAddMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5992;
    private boolean _isInitialized = false;
    private Vector.<PaddockItem> paddockItemDescription = ;
    private FuncTree _paddockItemDescriptiontree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5992;
    }

    public GameDataPaddockObjectListAddMessage initGameDataPaddockObjectListAddMessage(Vector.<PaddockItem> param1) {
         this.paddockItemDescription = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.paddockItemDescription = new Vector.<PaddockItem>();
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
         this.serializeAs_GameDataPaddockObjectListAddMessage(param1);
    }

    public void serializeAs_GameDataPaddockObjectListAddMessage(ICustomDataOutput param1) {
         param1.writeShort(this.paddockItemDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddockItemDescription.length)
            (this.paddockItemDescription[_loc2_] as PaddockItem).serializeAs_PaddockItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameDataPaddockObjectListAddMessage(param1);
    }

    public void deserializeAs_GameDataPaddockObjectListAddMessage(ICustomDataInput param1) {
         PaddockItem _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new PaddockItem();
            _loc4_.deserialize(param1);
            this.paddockItemDescription.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameDataPaddockObjectListAddMessage(param1);
    }

    public void deserializeAsyncAs_GameDataPaddockObjectListAddMessage(FuncTree param1) {
         this._paddockItemDescriptiontree = param1.addChild(this._paddockItemDescriptiontreeFunc);
    }

    private void _paddockItemDescriptiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._paddockItemDescriptiontree.addChild(this._paddockItemDescriptionFunc);
            _loc3_++;
    }

    private void _paddockItemDescriptionFunc(ICustomDataInput param1) {
         PaddockItem _loc2_ = new PaddockItem();
         _loc2_.deserialize(param1);
         this.paddockItemDescription.push(_loc2_);
    }

}