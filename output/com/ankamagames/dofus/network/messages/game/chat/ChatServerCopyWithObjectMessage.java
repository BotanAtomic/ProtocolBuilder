package package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatServerCopyWithObjectMessage extends ChatServerCopyMessage implements INetworkMessage {

    private int protocolId = 884;
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
         return 884;
    }

    public ChatServerCopyWithObjectMessage initChatServerCopyWithObjectMessage(int param1,String  param2,int  param3,String  param4,Number  param5,String  param6,Vector.<ObjectItem>  param7) {
         super.initChatServerCopyMessage(param1,param2,param3,param4,param5,param6);
         this.objects = param7;
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
         this.serializeAs_ChatServerCopyWithObjectMessage(param1);
    }

    public void serializeAs_ChatServerCopyWithObjectMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatServerCopyMessage(param1);
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
            (this.objects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatServerCopyWithObjectMessage(param1);
    }

    public void deserializeAs_ChatServerCopyWithObjectMessage(ICustomDataInput param1) {
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
         this.deserializeAsyncAs_ChatServerCopyWithObjectMessage(param1);
    }

    public void deserializeAsyncAs_ChatServerCopyWithObjectMessage(FuncTree param1) {
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