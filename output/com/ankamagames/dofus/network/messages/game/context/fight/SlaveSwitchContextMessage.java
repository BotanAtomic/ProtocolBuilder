package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SpellItem;
import com.ankamagames.dofus.network.types.game.character.characteristic.CharacterCharacteristicsInformations;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SlaveSwitchContextMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6214;
    private boolean _isInitialized = false;
    private Number masterId = 0;
    private Number slaveId = 0;
    private Vector.<SpellItem> slaveSpells = ;
    private CharacterCharacteristicsInformations slaveStats = ;
    private Vector.<Shortcut> shortcuts = ;
    private FuncTree _slaveSpellstree = ;
    private FuncTree _slaveStatstree = ;
    private FuncTree _shortcutstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private Shortcut _loc8_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private Shortcut _loc3_ = ProtocolTypeManager.getInstance(Shortcut,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6214;
    }

    public SlaveSwitchContextMessage initSlaveSwitchContextMessage(Number param1,Number  param2,Vector.<SpellItem>  param3,CharacterCharacteristicsInformations  param4,Vector.<Shortcut>  param5) {
         this.masterId = param1;
         this.slaveId = param2;
         this.slaveSpells = param3;
         this.slaveStats = param4;
         this.shortcuts = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.masterId = 0;
         this.slaveId = 0;
         this.slaveSpells = new Vector.<SpellItem>();
         this.slaveStats = new CharacterCharacteristicsInformations();
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
         this.serializeAs_SlaveSwitchContextMessage(param1);
    }

    public void serializeAs_SlaveSwitchContextMessage(ICustomDataOutput param1) {
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.masterId + ") on element masterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SlaveSwitchContextMessage(param1);
    }

    public void deserializeAs_SlaveSwitchContextMessage(ICustomDataInput param1) {
         SpellItem _loc6_ = null;
         int _loc7_ = 0;
         Shortcut _loc8_ = null;
         this._masterIdFunc(param1);
         this._slaveIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = new SpellItem();
            _loc6_.deserialize(param1);
            this.slaveSpells.push(_loc6_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SlaveSwitchContextMessage(param1);
    }

    public void deserializeAsyncAs_SlaveSwitchContextMessage(FuncTree param1) {
         param1.addChild(this._masterIdFunc);
         param1.addChild(this._slaveIdFunc);
         this._slaveSpellstree = param1.addChild(this._slaveSpellstreeFunc);
         this._slaveStatstree = param1.addChild(this._slaveStatstreeFunc);
         this._shortcutstree = param1.addChild(this._shortcutstreeFunc);
    }

    private void _masterIdFunc(ICustomDataInput param1) {
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.masterId + ") on element of SlaveSwitchContextMessage.masterId.");
    }

    private void _slaveIdFunc(ICustomDataInput param1) {
         this.slaveId = param1.readDouble();
         if(this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.slaveId + ") on element of SlaveSwitchContextMessage.slaveId.");
    }

    private void _slaveSpellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._slaveSpellstree.addChild(this._slaveSpellsFunc);
            _loc3_++;
    }

    private void _slaveSpellsFunc(ICustomDataInput param1) {
         SpellItem _loc2_ = new SpellItem();
         _loc2_.deserialize(param1);
         this.slaveSpells.push(_loc2_);
    }

    private void _slaveStatstreeFunc(ICustomDataInput param1) {
         this.slaveStats = new CharacterCharacteristicsInformations();
         this.slaveStats.deserializeAsync(this._slaveStatstree);
    }

    private void _shortcutstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._shortcutstree.addChild(this._shortcutsFunc);
            _loc3_++;
    }

    private void _shortcutsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         Shortcut _loc3_ = ProtocolTypeManager.getInstance(Shortcut,_loc2_);
         _loc3_.deserialize(param1);
         this.shortcuts.push(_loc3_);
    }

}