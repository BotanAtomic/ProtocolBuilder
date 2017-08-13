package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorFightersInformation extends Object implements INetworkType {

    private int protocolId = 169;
    private int collectorId = 0;
    private Vector.<CharacterMinimalPlusLookInformations> allyCharactersInformations = ;
    private Vector.<CharacterMinimalPlusLookInformations> enemyCharactersInformations = ;
    private FuncTree _allyCharactersInformationstree = ;
    private FuncTree _enemyCharactersInformationstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private CharacterMinimalPlusLookInformations _loc7_ = null;
    private int _loc8_ = 0;
    private CharacterMinimalPlusLookInformations _loc9_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private CharacterMinimalPlusLookInformations _loc3_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
    private int _loc3_ = 0;
    private CharacterMinimalPlusLookInformations _loc3_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);


    public int getTypeId() {
         return 169;
    }

    public TaxCollectorFightersInformation initTaxCollectorFightersInformation(int param1,Vector.<CharacterMinimalPlusLookInformations>  param2,Vector.<CharacterMinimalPlusLookInformations>  param3) {
         this.collectorId = param1;
         this.allyCharactersInformations = param2;
         this.enemyCharactersInformations = param3;
         return this;
    }

    public void reset() {
         this.collectorId = 0;
         this.allyCharactersInformations = new Vector.<CharacterMinimalPlusLookInformations>();
         this.enemyCharactersInformations = new Vector.<CharacterMinimalPlusLookInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorFightersInformation(param1);
    }

    public void serializeAs_TaxCollectorFightersInformation(ICustomDataOutput param1) {
         param1.writeInt(this.collectorId);
         param1.writeShort(this.allyCharactersInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.allyCharactersInformations.length)
            param1.writeShort((this.allyCharactersInformations[_loc2_] as CharacterMinimalPlusLookInformations).getTypeId());
            (this.allyCharactersInformations[_loc2_] as CharacterMinimalPlusLookInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorFightersInformation(param1);
    }

    public void deserializeAs_TaxCollectorFightersInformation(ICustomDataInput param1) {
         int _loc6_ = 0;
         CharacterMinimalPlusLookInformations _loc7_ = null;
         int _loc8_ = 0;
         CharacterMinimalPlusLookInformations _loc9_ = null;
         this._collectorIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc6_);
            _loc7_.deserialize(param1);
            this.allyCharactersInformations.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorFightersInformation(param1);
    }

    public void deserializeAsyncAs_TaxCollectorFightersInformation(FuncTree param1) {
         param1.addChild(this._collectorIdFunc);
         this._allyCharactersInformationstree = param1.addChild(this._allyCharactersInformationstreeFunc);
         this._enemyCharactersInformationstree = param1.addChild(this._enemyCharactersInformationstreeFunc);
    }

    private void _collectorIdFunc(ICustomDataInput param1) {
         this.collectorId = param1.readInt();
    }

    private void _allyCharactersInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._allyCharactersInformationstree.addChild(this._allyCharactersInformationsFunc);
            _loc3_++;
    }

    private void _allyCharactersInformationsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         CharacterMinimalPlusLookInformations _loc3_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.allyCharactersInformations.push(_loc3_);
    }

    private void _enemyCharactersInformationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._enemyCharactersInformationstree.addChild(this._enemyCharactersInformationsFunc);
            _loc3_++;
    }

    private void _enemyCharactersInformationsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         CharacterMinimalPlusLookInformations _loc3_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.enemyCharactersInformations.push(_loc3_);
    }

}