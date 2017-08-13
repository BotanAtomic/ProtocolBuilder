package package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PrismFightersInformation extends Object implements INetworkType {

    private int protocolId = 443;
    private int subAreaId = 0;
    private ProtectedEntityWaitingForHelpInfo waitingForHelpInfo = ;
    private Vector.<CharacterMinimalPlusLookInformations> allyCharactersInformations = ;
    private Vector.<CharacterMinimalPlusLookInformations> enemyCharactersInformations = ;
    private FuncTree _waitingForHelpInfotree = ;
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
         return 443;
    }

    public PrismFightersInformation initPrismFightersInformation(int param1,ProtectedEntityWaitingForHelpInfo  param2,Vector.<CharacterMinimalPlusLookInformations>  param3,Vector.<CharacterMinimalPlusLookInformations>  param4) {
         this.subAreaId = param1;
         this.waitingForHelpInfo = param2;
         this.allyCharactersInformations = param3;
         this.enemyCharactersInformations = param4;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.enemyCharactersInformations = new Vector.<CharacterMinimalPlusLookInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PrismFightersInformation(param1);
    }

    public void serializeAs_PrismFightersInformation(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismFightersInformation(param1);
    }

    public void deserializeAs_PrismFightersInformation(ICustomDataInput param1) {
         int _loc6_ = 0;
         CharacterMinimalPlusLookInformations _loc7_ = null;
         int _loc8_ = 0;
         CharacterMinimalPlusLookInformations _loc9_ = null;
         this._subAreaIdFunc(param1);
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.waitingForHelpInfo.deserialize(param1);
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
         this.deserializeAsyncAs_PrismFightersInformation(param1);
    }

    public void deserializeAsyncAs_PrismFightersInformation(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         this._waitingForHelpInfotree = param1.addChild(this._waitingForHelpInfotreeFunc);
         this._allyCharactersInformationstree = param1.addChild(this._allyCharactersInformationstreeFunc);
         this._enemyCharactersInformationstree = param1.addChild(this._enemyCharactersInformationstreeFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightersInformation.subAreaId.");
    }

    private void _waitingForHelpInfotreeFunc(ICustomDataInput param1) {
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.waitingForHelpInfo.deserializeAsync(this._waitingForHelpInfotree);
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