package package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class NpcDialogQuestionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5617;
    private boolean _isInitialized = false;
    private int messageId = 0;
    private Vector.<String> dialogParams = ;
    private Vector.<uint> visibleReplies = ;
    private FuncTree _dialogParamstree = ;
    private FuncTree _visibleRepliestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5617;
    }

    public NpcDialogQuestionMessage initNpcDialogQuestionMessage(int param1,Vector.<String>  param2,Vector.<uint>  param3) {
         this.messageId = param1;
         this.dialogParams = param2;
         this.visibleReplies = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.messageId = 0;
         this.dialogParams = new Vector.<String>();
         this.visibleReplies = new Vector.<uint>();
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
         this.serializeAs_NpcDialogQuestionMessage(param1);
    }

    public void serializeAs_NpcDialogQuestionMessage(ICustomDataOutput param1) {
         if(this.messageId < 0)
            throw new Exception("Forbidden value (" + this.messageId + ") on element messageId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NpcDialogQuestionMessage(param1);
    }

    public void deserializeAs_NpcDialogQuestionMessage(ICustomDataInput param1) {
         String _loc6_ = null;
         int _loc7_ = 0;
         this._messageIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUTF();
            this.dialogParams.push(_loc6_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NpcDialogQuestionMessage(param1);
    }

    public void deserializeAsyncAs_NpcDialogQuestionMessage(FuncTree param1) {
         param1.addChild(this._messageIdFunc);
         this._dialogParamstree = param1.addChild(this._dialogParamstreeFunc);
         this._visibleRepliestree = param1.addChild(this._visibleRepliestreeFunc);
    }

    private void _messageIdFunc(ICustomDataInput param1) {
         this.messageId = param1.readVarUhInt();
         if(this.messageId < 0)
            throw new Exception("Forbidden value (" + this.messageId + ") on element of NpcDialogQuestionMessage.messageId.");
    }

    private void _dialogParamstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._dialogParamstree.addChild(this._dialogParamsFunc);
            _loc3_++;
    }

    private void _dialogParamsFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.dialogParams.push(_loc2_);
    }

    private void _visibleRepliestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._visibleRepliestree.addChild(this._visibleRepliesFunc);
            _loc3_++;
    }

    private void _visibleRepliesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of visibleReplies.");
    }

}