package package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatClientMultiWithObjectMessage extends ChatClientMultiMessage implements INetworkMessage {

    private int protocolId = 862;
    private boolean _isInitialized = false;
    private Vector.<ObjectItem> objects = ;
    private FuncTree _objectstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 862;
    }

    public ChatClientMultiWithObjectMessage initChatClientMultiWithObjectMessage(String param1,int  param2,Vector.<ObjectItem>  param3) {
         super.initChatClientMultiMessage(param1,param2);
         this.objects = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.objects = new Vector.<ObjectItem>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_ChatClientMultiWithObjectMessage(param1);
    }

    public void serializeAs_ChatClientMultiWithObjectMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatClientMultiMessage(param1);
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
            (this.objects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatClientMultiWithObjectMessage(param1);
    }

    public void deserializeAs_ChatClientMultiWithObjectMessage(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatClientMultiWithObjectMessage(param1);
    }

    public void deserializeAsyncAs_ChatClientMultiWithObjectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objectstree = param1.addChild(this._objectstreeFunc);
    }

    private void _objectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectstree.addChild(this._objectsFunc);
            _loc3_++;
    }

    private void _objectsFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.objects.push(_loc2_);
    }

}