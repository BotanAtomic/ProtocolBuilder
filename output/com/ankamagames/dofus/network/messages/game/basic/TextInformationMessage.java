package package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TextInformationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 780;
    private boolean _isInitialized = false;
    private int msgType = 0;
    private int msgId = 0;
    private Vector.<String> parameters = ;
    private FuncTree _parameterstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 780;
    }

    public TextInformationMessage initTextInformationMessage(int param1,int  param2,Vector.<String>  param3) {
         this.msgType = param1;
         this.msgId = param2;
         this.parameters = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.msgType = 0;
         this.msgId = 0;
         this.parameters = new Vector.<String>();
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
         this.serializeAs_TextInformationMessage(param1);
    }

    public void serializeAs_TextInformationMessage(ICustomDataOutput param1) {
         param1.writeByte(this.msgType);
         if(this.msgId < 0)
            throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TextInformationMessage(param1);
    }

    public void deserializeAs_TextInformationMessage(ICustomDataInput param1) {
         String _loc4_ = null;
         this._msgTypeFunc(param1);
         this._msgIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TextInformationMessage(param1);
    }

    public void deserializeAsyncAs_TextInformationMessage(FuncTree param1) {
         param1.addChild(this._msgTypeFunc);
         param1.addChild(this._msgIdFunc);
         this._parameterstree = param1.addChild(this._parameterstreeFunc);
    }

    private void _msgTypeFunc(ICustomDataInput param1) {
         this.msgType = param1.readByte();
         if(this.msgType < 0)
            throw new Exception("Forbidden value (" + this.msgType + ") on element of TextInformationMessage.msgType.");
    }

    private void _msgIdFunc(ICustomDataInput param1) {
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
            throw new Exception("Forbidden value (" + this.msgId + ") on element of TextInformationMessage.msgId.");
    }

    private void _parameterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._parameterstree.addChild(this._parametersFunc);
            _loc3_++;
    }

    private void _parametersFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.parameters.push(_loc2_);
    }

}